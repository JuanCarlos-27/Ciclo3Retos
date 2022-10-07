$.get("/user",(data)=>{
        const nameUser = data.name === null ? data.login : data.name;
        Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Bienvenido '+ nameUser,
            showConfirmButton: false,
            showCloseButton: true,
            timerProgressBar:true,
            timer: 5000
        })
});
const leerPalco = () => {
    $.ajax({
        url : 'http://150.136.154.173:8080/api/Box/all',
        type : 'GET',
        dataType : 'json',
        success : function(palco) {
            $("tbody").empty();
            let tabla = `<tbody>`;
            for (let i = 0; i < palco.length; i++) {
                tabla += `<tr>
                            <th scope="row">${palco[i].id}</th>
                            <td>${palco[i].name}</td>
                            <td>${palco[i].location}</td>
                            <td>${palco[i].capacity}</td>
                            <td>${palco[i].description}</td> 
                            <td>${palco[i].category.id}</td>
                            <td>
                                <button type="button" class="btn btn-info" onclick='llenarInputs(${JSON.stringify(palco[i])})' data-bs-toggle="modal" data-bs-target="#modalBoxEdit" data-bs-whatever="@mdo"><i class="bi bi-pencil-square"></i></button>
                                <button type="button" class="btn btn-danger" id="btnBorrar" onclick="eliminarPalco(${palco[i].id})"><i class="bi bi-trash3-fill"></i></button>
                            </td>
                          <tr>`
            }
            $("option").remove();
            leerCategorias();
            tabla += '</tbody>'

            $("#boxTable").append(tabla);
        },
        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },
    });
}

const leerCategorias = () => {
    $.ajax({
        url : 'http://150.136.154.173:8080/api/Category/all',
        type : 'GET',
        dataType : 'json',
        success : function(c) {
            c.forEach(e => {
                $('#categoryIdSelect').prepend(`<option value=${e.id}>${e.id} - ${e.name}</option>`);
            });
        },
        error : function(xhr, status) {
            alert('Disculpe, existió un problema');
        },
    });
}

window.addEventListener("load", leerPalco);

const llenarInputs = (info) =>{
    $("#idUpdate").val(info.id)
    $("#locationUpdate").val(info.location)
    $("#capacityUpdate").val(info.capacity)
    $("#nameUpdate").val(info.name)
    $("#descriptionUpdate").val(info.description)
}
const limpiarCampos = ()=>{
    $("#location").val(null);
    $("#capacity").val(null);
    $("#name").val(null);
    $("#description").val(null);
}

const dataPalcoToSend = ()=>{
    let data={
        id: $("#id").val(),
        location: $("#location").val(),
        capacity: $("#capacity").val(),
        name: $("#name").val(),
        description: $("#description").val(),
        category: {
            "id":$("#categoryIdSelect").val()
        }
    };
    return JSON.stringify(data);
}
const dataPalcoToEdit = ()=>{
    let data={
        id: $("#idUpdate").val(),
        location: $("#locationUpdate").val(),
        capacity: $("#capacityUpdate").val(),
        name: $("#nameUpdate").val(),
        description: $("#descriptionUpdate").val(),
    };
    return JSON.stringify(data);
}

const editar = (url, datos, consulta)=>{
    $.ajax({    
        url : url,
        type : 'PUT',
        data: datos(),
        contentType:'application/json',
        success : function() {
        },
        error : function(xhr, status) {
       //     alert('ha sucedido un problema');
        },
        complete: function(){
            consulta();
        }
    });
}

const guardar = (url, datos, consulta)=> {
    $.ajax({    
        url : url,
        type : 'POST',
        data: datos(),
        contentType:'application/json',
        success : function() {
            limpiarCampos();
        },
        complete: function(){
            consulta();
        }
    });
}
$("#btnAgregarPalco").on("click", ()=>{
    guardar('http://150.136.154.173:8080/api/Box/save',dataPalcoToSend, leerPalco);
    $("#btnAgregarPalco").attr("data-bs-dismiss","modal")
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: '¡Se ha creado correctamente!',
        showConfirmButton: false,
        timer: 1500
      })
});


$("#btnActualizarPalco").on("click", ()=>{
    editar('http://150.136.154.173:8080/api/Box/update',dataPalcoToEdit, leerPalco);
    $("#btnActualizarPalco").attr("data-bs-dismiss","modal")
    Swal.fire({
        position: 'center',
        icon: 'success',
        title: '¡Se ha actualizado correctamente!',
        showConfirmButton: false,
        timer: 1500
      })
});

const eliminarPalco = (idPalco) =>{
    let data = {
        id: idPalco
    }
    Swal.fire({
        title: '¿Estas seguro?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '¡Si, eliminar!'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({    
                url : `http://150.136.154.173:8080/api/Box/${idPalco}`,
                type : 'DELETE',
                data: JSON.stringify(data),
                contentType:'application/json',
                success : function() {
                    Swal.fire(
                        '¡Eliminado!',
                        'Se ha eliminado correctamente.',
                        'success'
                      )
                },
                error : function(xhr, status) {
                },
                complete: function(){
                    leerPalco();
                }
            });
        }
      })
}
