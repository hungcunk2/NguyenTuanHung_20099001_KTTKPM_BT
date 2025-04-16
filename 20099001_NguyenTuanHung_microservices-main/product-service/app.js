// product-service/app.js
const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3001;

app.use(express.json());

mongoose.connect('mongodb://mongo:27017/products', { useNewUrlParser: true, useUnifiedTopology: true });

const productSchema = new mongoose.Schema({
    name: String,
    price: Number,
    description: String,
    stock: Number
});

const Product = mongoose.model('Product', productSchema);

app.post('/products', async(req, res) => {
    const { name, price, description, stock } = req.body;
    const product = new Product({ name, price, description, stock });
    await product.save();
    res.status(201).send(product);
});

app.get('/products/:id', async(req, res) => {
    const product = await Product.findById(req.params.id);
    if (!product) {
        return res.status(404).send({ message: 'Product not found' });
    }
    res.send(product);
});

app.listen(port, () => {
    console.log(`Product Service running on http://localhost:${port}`);
});