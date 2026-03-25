require("dotenv").config();
const express = require("express");

const app = express();

const PORT = process.env.PORT || 3000;

app.use(express.json());

app.get("/", (req, res) => {
    res.json({message:"Node service running"});
});

app.get("/hello/:name", (req, res) => {
    res.json({message:`Hello ${req.params.name} from Node`});
});

app.post("/add", (req, res) => {
    const {a,b} = req.body;
    res.json({result:a+b});
});

app.listen(PORT, () => {
    console.log(`Node server running on port ${PORT}`);
});