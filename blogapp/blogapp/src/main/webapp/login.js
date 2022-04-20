/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

console.log("script start ok...");

// recupero dei dati dal file login.html
let txtuser = document.getElementById("iduser");
let txtpassword = document.getElementById("idpassword");
let btnconferma = document.getElementById("btnconferma");

btnconferma.addEventListener( "click", v => {
    v.preventDefault(); // non fa il summit 
    const credential = {
      user:txtuser.value,
      password:txtpassword.value
    };
    
    //console.log(JSON.stringify(credential)); // JSON -> classe per lavorare con i file JSON 
    
    fetch("http://localhost:8080/blogapp/resource/users/login",{
       method: 'POST',
       headers: {
         'Content-Type':'application/json'  
       },
       body: JSON.stringify(credential)
       }).then(response => response.json())
               .then(data => console.log(data));
            
});

const visualizzaUsers = () => {
    fetch("http://localhost:8080/blogapp/resource/users",{
        method:'GET',
    })
            .then(response => {
                console.log(response);
    })
}