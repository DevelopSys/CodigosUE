let boton = document.querySelector("button");
let selectGenero = document.querySelector("#select-genero");
let selectPais = document.querySelector("#select-pais");
let inputResultados = document.querySelector("input");
let resultados = document.querySelector("#resultados");

boton.addEventListener("click", (e) => {
  let url = `https://randomuser.me/api/?gender=${selectGenero.value}&results=${inputResultados.value}&nat=${selectPais.value}`;
  procesarPeticion(url);
});

async function procesarPeticion(url) {
  let contador = 0;
  resultados.innerHTML = "";
  let resutladoJSON = await fetch(url);
  let resultadoTotal = await resutladoJSON.json();
  console.log(resultadoTotal);
  resultadoTotal.results.forEach((element, index) => {
    setTimeout(() => {
      resultados.innerHTML += ` <div class="col mt-3">
        <div class="card animate__animated animate__fadeIn" style="width: 18rem">
          <img src='${element.picture.large}' class="card-img-top" alt="..." />
          <div class="card-body">
            <h5 class="card-title">${element.name.first} ${element.name.last}</h5>
            <button class="btn btn-primary" id="usuario-${contador}">Ver detalle</button>
          </div>
        </div>
      </div>`;
      contador++;
    }, index * 500);
  });

  /* 
  fetch(url)
    .then((res) => {
        // hago algo con el 
      return res.json();
    })
    .then((res1) => {
      console.log(res1);
    }); */
}
