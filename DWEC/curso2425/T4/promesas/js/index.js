/* setTimeout(() => {
  console.log("Ejecución postergada");
}, 2000);

setInterval(() => {
  console.log("Ejecucion recurrente");
}, 2000);
 */

/* let promesa = new Promise((res, rej) => {

  setTimeout(() => {
    console.log("Ejecucion postergada");
  }, 2000);
});
 */

/* fetch("https://dummyjson.com/product")
  .then((response) => {
    console.log("respuesta obtenida");
    console.log("paso a traducirla a json");
    return response.json();
  })
  .then((response1) => {
    console.log("respuesta traducidaa a json correctamente");
    console.log(response1);
  })
  .catch(() => {
    console.log("contestacion incorrecta");
  }); */

/* let promesa = new Promise((res, rej) => {
  // logica de la promesa
  setTimeout(() => {
    let numero = Math.random() * 10;
    // si el numero es mayor que 5 -> resuelta de forma correcta
    // si el numero es menor que 5 -> resuelta de forma incorrecta
    if (numero < 5) {
      rej("Numero muy pequeño");
    } else {
      res(numero);
    }
  }, 2000);
});
 */
// then -> tratar la respuesta correcta
// catch -> tratar la respuesta incorrecta

/* promesa
  .then((resolve) => {
    console.log(`Numero calculado con valor ${resolve}`);
    resolve.json();
  })
  .catch((error) => {
    console.log(error);
  }); */

//JSONObject -> JSONArray -> foreach -> JSONObject

let productosTotales;
let productosFiltrados;

fetch("https://dummyjson.com/products")
  .then((response) => response.json())
  .then((response1) => {
    console.log("respuest a traducidaa a json correctamente"); // 1segundo
    productosTotales = response1.products;
    console.log("Ejecutando mostrado con filtro");
    productosFiltrados = productosTotales.filter((item) => item.price < 100);
    productosFiltrados.forEach((element) => {
      console.log(`${element.title} ${element.price}`);
    });
  })
  .catch(() => {
    console.log("contestacion incorrecta");
  })
  .finally(() => {
    console.log("Finalizando dependencias de la promesa");
  });

setTimeout(() => {}, 190);

// CLIENTE                         // SERVIDO WEB                   // BD
// lo que pasa cuando esta contestacion es correcta -> then
// lo que pasa cuando esta constestacion es incorrecta -> catch
