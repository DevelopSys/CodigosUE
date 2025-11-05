package model;

import lombok.Data;

import java.util.List;

@Data

public class ProductoResponse {
    // TODO tipar la lista
    private List<Producto> products;
    private int total;
    private int skip;
    private int limit;
}
