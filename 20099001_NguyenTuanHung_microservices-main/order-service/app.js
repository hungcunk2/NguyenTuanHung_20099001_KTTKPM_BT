// order-service/app.js
const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3002;

app.use(express.json());

mongoose.connect('mongodb://mongo:27017/orders', { useNewUrlParser: true, useUnifiedTopology: true });

const orderSchema = new mongoose.Schema({
    customerId: String,
    productId: String,
    quantity: Number,
    status: { type: String, default: 'pending' }
});

const Order = mongoose.model('Order', orderSchema);

app.post('/orders', async(req, res) => {
    const { customerId, productId, quantity } = req.body;
    const order = new Order({ customerId, productId, quantity });
    await order.save();
    res.status(201).send(order);
});

app.listen(port, () => {
    console.log(`Order Service running on http://localhost:${port}`);
});