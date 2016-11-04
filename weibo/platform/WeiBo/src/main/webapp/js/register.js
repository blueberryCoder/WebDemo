/**
 * Created by Administrator on 2016/11/3.
 */
function setCookie(name, value) {
    var exp = new Date();
    exp.setTime(exp.getTime() + 60 * 60 * 1000);//存储一小时
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

function getCookie(name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(name + "=");
        if (c_start != -1) {
            c_start = c_start + name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);

            if (c_end == -1) {
                c_end = document.cookie.length;
            }
            return unescape(document.cookie.substring(c_start, c_end));
        }
    }

    return "";
}

function checkRegisterForm(form) {

    if (form.account.value == "") {
        alert("账号不能为空")
        return false;
    }

    if (form.password.value == "" || form.passwordAgain.value == "") {
        alert("密码不能为空")
        return false;
    }

    if (form.password.value != form.passwordAgain.value) {
        alert("密码不一致")
        return false;
    }

    form.password.value = encrypt(form.password.value);
    form.passwordAgain.value = encrypt(form.passwordAgain.value);

    return true;

}

function encrypt(org) {
    var publicKey = getCookie("security");
    // console.log("security:"+code);
    var encrypted = encypt(org,publicKey);
    
    return encrypted;
}

function encypt(org,publicKey) {
    var crypt = new JSEncrypt();
    crypt.setPublicKey(publicKey);
    var encrypted = crypt.encrypt(org);
    
    crypt.decrypt()
    return encrypted;
}
