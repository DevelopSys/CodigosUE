import React from "react";
import { Link } from "react-router-dom";
import type { Drink } from "../models/DrinksModels";

interface Props {
  drink: Drink;
}

const CocktailItem = ({ drink }: Props) => {
  return (
    <li
      key={drink.idDrink}
      className="m-4 list-group-item d-flex justify-content-between align-item-center"
    >
      <img src={drink.strDrinkThumb} width="50"></img>
      {drink.strDrink}
      <Link to={`/detail/${drink.idDrink}`} className="btn btn-primary">
        Detalle
      </Link>
    </li>
  );
};

export default CocktailItem;
