var id;
var estado;


var guardar = document.getElementById("guardar")
guardar.addEventListener("click", function () {
    axios.post("http://localhost:4567/usuario", {
        nombre : document.getElementById("Nombre").value,
        carrera : document.getElementById("Carrera").value
    })
    .then(function (response) {
        alert("mensaje: usuario creado "+response.data.status+" con id: "+response.data.id);
        id = response.data.id;
        estado=response.data.status;
    })
    .catch(function (error) {
        console.log(error);
    })
})

function usuarios(u) {
    let listTareas = document.getElementById("tareas")
    let text = "";
    for (let i = 0; i < u.length; i++) {
        let tarea = document.createElement("li");
        tarea.textContent = u[i].email + " " + u[i].id;
        listTareas.appendChild(tarea);
    }
}