export class ProductosDTO {

  constructor(data:Partial<ProductosDTO>) {
    Object.assign(this, data);
  }

  id?: number|null;
  nombre?: string|null;
  precio?: number|null;

}
