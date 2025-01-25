let url =
  "https://opentdb.com/api.php?amount=10&category=9&difficulty=medium&type=multiple";

async function consultaPreguntas() {
  // si utilizo un await
  let respuesta = await fetch(url);
  let respuestaJSON = await respuesta.json();
  respuestaJSON.results.forEach((element, index) => {
    console.log(`Pregunta ${index + 1}`);
    console.log(element.question);
    let respuestas = element.incorrect_answers;
    respuestas.push(element.correct_answer);
    console.log(respuestas);

    // OBJETO PREGUNTA
  });
}

function pintarPregunta(pregunta) {

    divPRegunta.innerHTML = 
    
}

consultaPreguntas();
