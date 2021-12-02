import React from "react";
import classes from "./styles.module.css";

const CartItem = (props) => {
    const { id, title, price, description, category,quantity} = props;

    return (
        <div className={classes.cartitem}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>

        </div>
    );
};
export default CartItem;