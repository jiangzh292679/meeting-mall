$(document).ready(function () {
    var editor = new Simditor({
        textarea: $('#editor'),
        pasteImage: true,
        upload: {
            url: '/manage/product/richtext_img_upload.do',
            params: null,
            fileKey: "upload_file",
            connectionCount: 1,
            leaveConfirm: "正在上传,确定要取消上传文件吗?"
        }
        //defaultImage: Feng.ctxPath + '/static/img/a9.jpg'
    });


    var productEdit = {
        init : function () {
            this.bindEvent();
        },
        bindEvent : function () {
            $('#product-add').click(function () {
                // 分别有三种数据需要组织：基础信息、主图和富文本
                // 组织基础信息数据
                var name = $('#productName').val();
                var subtitle = $('#productDesc').val();
                var price = $('#productPrice').val();
                var stock = $('#productStock').val();
                var categoryId = $('#categoryId').val();

                // 组织主图信息
                var $imgUrls = $('.imageDiv input[name=imageUri]');
                var mainImage = '';
                var subImages = '';
                $imgUrls.each(function (index,element) {
                    if(index===0){
                        mainImage = $(this).val();
                    }
                    subImages += ','+$(this).val();
                })
                subImages = subImages.substring(1);

                // 获取富文本信息
                var detail = $('#editor').val();

                var data = {};
                data.name = name;
                data.subtitle = subtitle;
                data.price = price;
                data.stock = stock;
                data.categoryId = categoryId;
                data.mainImage = mainImage;
                data.subImages = subImages;
                data.detail = detail;

                $.post('/manage/product/save.do',data,function (result) {
                    if(result.status === 0){
                        window.parent.MeetingProduct.table.refresh();
                        parent.layer.close(window.parent.MeetingProduct.layerIndex);
                    }
                },'json');

            }),
            $('#upload_file').change(function () {
                // 获取父节点
                var $imgShowcase = $('.imageShowcase');
                var requestUrl = "/manage/product/upload.do";
                $("#fileUploadForm").ajaxSubmit({
                    type: 'post',
                    url: requestUrl,
                    contentType: "application/x-www-form-urlencoded; charset=utf-8",
                    success: function(data) {
                        if(data.status===0){
                            var imgDivStr = '<div class=\"imageDiv\">';
                            imgDivStr += '<input type="hidden" name="imageUri" class="imageUri" value="'+data.data.uri+'" />';
                            imgDivStr += '<img class="main-image" src="'+data.data.url+'">';
                            imgDivStr += '</div>';
                            // 构建子节点
                            var $imgDivStr = $(imgDivStr);
                            $imgShowcase.append($imgDivStr);
                        }
                    }
                });
            })
        }
    }

    productEdit.init();
});