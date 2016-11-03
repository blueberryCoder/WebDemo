/**
 * Created by Administrator on 2016/11/1.
 */
function checkForm(o) {
    if (o.account.value == "") {
        alert("账号不能为空")
        return false;
    }

    if (o.password.value == "") {
        alert("密码不能为空")
        return false;
    }
    return true;
}

