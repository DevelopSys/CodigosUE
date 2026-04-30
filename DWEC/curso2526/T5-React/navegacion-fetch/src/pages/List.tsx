import React, { useEffect, useState } from "react";
import type { Drink, DrinkReponse } from "../models/DrinksModels";
import CocktailItem from "../components/CocktailItem";

const List = () => {
  const [cocktails, setCocktails] = useState<Drink[]>([]);

  useEffect(() => {
    const cocktailsFetch = async () => {
      const cocktailAPI = await fetch(
        "https://www.thecocktaildb.com/api/json/v1/1/filter.php?a=Non_Alcoholic",
      );

      const cocktailResponse: DrinkReponse = await cocktailAPI.json();

      setCocktails(cocktailResponse.drinks);
      // console.log(cocktailResponse.drinks);
    };

    cocktailsFetch();
    // lo que se realiza cuando se detecte un efecto (actualizacion)
    // la funcion de callback ejecutada despues del efecto
    /* return () => {
        second
      } */
  }, []);

  return (
    <div>
      <h1>Lista de Cocktails</h1>
      <ul className="list-group">
        {/* capturar la lista de cocktail de me ha dado el api y hacer un li por cada uno  */}
        {/* {cocktails.map((data: Drink) => (
          <li className="list-group-item d-flex justify-content-between">
            <img src={data.strDrinkThumb} width="50"></img>
            {data.strDrink}
            <Link to={"/detail"} className="btn btn-primary">
              Detalle
            </Link>
          </li>
        ))} */}
        {cocktails.map((data: Drink) => (
          <CocktailItem key={data.idDrink} drink={data} />
        ))}
      </ul>
    </div>
  );
};

export default List;
