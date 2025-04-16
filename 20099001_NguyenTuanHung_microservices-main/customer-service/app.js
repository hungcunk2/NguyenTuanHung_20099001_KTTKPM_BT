// customer-service/app.js
const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = 3003;

app.use(express.json());

mongoose.connect('mongodb://mongo:27017/customers', { useNewUrlParser: true, useUnifiedTopology: true });

const customerSchema = new mongoose.Schema({
    name: String,
    email: String,
    phone: String
});

const Customer = mongoose.model('Customer', customerSchema);

app.post('/customers', async(req, res) => {
    const { name, email, phone } = req.body;
    const customer = new Customer({ name, email, phone });
    await customer.save();
    res.status(201).send(customer);
});

app.listen(port, () => {
    console.log(`Customer Service running on http://localhost:${port}`);
});