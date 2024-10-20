// promesa -> lanzar a ejecutar (¿cuanto tarda?) -> acepte (resolucion res), rechace (resoluciopn rej)
// acceso a base de datos
// acceso a fs
// tarea pesada -> calculos

// personalizadas y lanzada
/* let promesa = new Promise((res, rej) => {
  // la ejecucion de la promesa
  setTimeout(() => {
    let aleatorio = Math.random() * 10;
    if (aleatorio >= 5) {
      res(aleatorio);
    } else {
      rej("Algo ha ido mal, numero pequeño");
    }
  }, 2000);
}); */

// then -> cuando la promesa se resuelve ok
// catch -> cuando la promesa se resuelve rej
// finally -> siempre
/*promesa
  .then((res) => {
    console.log(res);
    return res;
  })
  .then((res1) => {
    console.log(res1 * 2);
  })
  .catch((err) => {
    console.log(err);
  })
  .finally(() => {
    console.log("Ejecutando siempre");
  });
*/

async function crearPromesa() {
  let promesa = new Promise((res, rej) => {
    // la ejecucion de la promesa
    setTimeout(() => {
      let aleatorio = Math.random() * 10;
      if (aleatorio >= 5) {
        res(aleatorio);
      } else {
        rej("Algo ha ido mal, numero pequeño");
      }
    }, 2000);
  });

  let resultado = await promesa;
}

/* fetch("https://randomuser.me/api/?results=50")
  .then((res) => res.json())
  .then((res1) => {
    res1.results.forEach((element) => {
      console.log(element.name.first);
    });
  }); */

async function resolverAPI() {
  let resultado = await fetch("https://randomuser.me/api/?results=50");
  let resultadoJSON = await resultado.json();
  console.log(resultadoJSON);
}

resolverAPI();

/* setInterval(() => {
  console.log("Ejecutando intervalo");
}, 500); */
// ya creadas
