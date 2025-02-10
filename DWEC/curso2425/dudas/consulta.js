let preguntas = [];

async function consultaPreguntas(params) {
  let peticion1 = await fetch("https://opentdb.com/api.php?amount=10");
  let peticion2 = await peticion1.json();
  peticion2.results.forEach((element) => {
    preguntas.push(
      new Pregunta(
        element.type,
        element.difficulty,
        element.category,
        element.question,
        element.correct_answer,
        element.incorrect_answer
      )
    );
  });
}
