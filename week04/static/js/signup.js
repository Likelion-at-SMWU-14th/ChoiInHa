function checkPassword() {
    const password = document.getElementById("password1").value;
    const password2 = document.getElementById("password2").value;
    
    if (password !== password2) {
        alert("비밀번호가 달라요. 다시 입력해주세요.");
        return false; 
    }
    return true; 
}