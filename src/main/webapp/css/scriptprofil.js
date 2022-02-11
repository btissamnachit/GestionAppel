"use strict";
class PictureUpdate {
    constructor() {
        this.profile = $('.profile-pic'); //direct parent
        this.cover = $('.cover'); //direct parent
        this.updateProfile();
        this.updateCover();
    }
    updateProfile() {
        var input = $('input', this.profile);
        input.change((e) => {
            var img = URL.createObjectURL(e.target.files[0]);
            this.fireAJAX(null, img, this.profile);
        });
    }
    updateCover() {
        var input = $('input', this.cover);
        input.change((e) => {
            var img = URL.createObjectURL(e.target.files[0]);
            this.fireAJAX(null, img, this.cover);
        });
    }
    fireAJAX(url, data, element) {
        $.ajax({
            type: "POST",
            data: data,
            beforeSend: () => {
                this.startLoader(element);
            },
            success: () => {
                setTimeout(() => {
                    this.destroyLoader(element);
                    $('> img', element).attr("src", data);
                }, 2000);
            }
        });
    }
    startLoader(element) {
        var loader = $('.layer', element);
        loader.addClass("visible");
    }
    destroyLoader(element) {
        var loader = $('.layer', element);
        loader.removeClass("visible");
    }
}
new PictureUpdate();