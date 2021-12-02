import React, { Component } from "react";
import CartItem from "../../components/cartitem";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../button";

class CartList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            search: [],
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            quantityCart:0
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleCheckoutCart = this.handleCheckoutCart.bind(this);
    }
    componentDidMount() {
        this.loadData();
    }
    async loadData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    async handleCheckoutCart(event){

        try{
            const { data } = await APIConfig.get("/cart");

        }
        catch (error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <Button action={this.handleCheckoutCart()}>
                    Checkout
                </Button>

                <div>
                    {this.state.items.map((item) => (
                        <CartItem
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            quantity={item.quantity}

                        />
                    ))}
                </div>

            </div>
        );
    }
}
export default CartList;