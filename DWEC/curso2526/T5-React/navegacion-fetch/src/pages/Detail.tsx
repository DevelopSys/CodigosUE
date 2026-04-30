import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import type { DrinkDetail, DrinkDetailReponse } from "../models/DrinksModels";

const Detail = () => {
  const { id } = useParams<{ id: string }>();
  const [cockatil, setCockatil] = useState<DrinkDetail>();

  useEffect(() => {
    const detailFetch = async () => {
      const detailReponse = await fetch(
        "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=" + id,
      );

      const detailJSON: DrinkDetailReponse = await detailReponse.json();

      setCockatil(detailJSON.drinks[0]);
    };

    detailFetch();
  }, []);

  return (
    <div>
      Detail
      <p>{id}</p>
      <p>{cockatil?.strDrink}</p>
      <p>{cockatil?.strCategory}</p>
    </div>
  );
};

export default Detail;
