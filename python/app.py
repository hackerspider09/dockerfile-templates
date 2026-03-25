import os
from flask import Flask, jsonify, request

app = Flask(__name__)

PORT = int(os.getenv("PORT", 5000))

@app.route("/")
def home():
    return jsonify({"message": "Python service running"})

@app.route("/hello/<name>")
def hello(name):
    return jsonify({"message": f"Hello {name} from Python"})

@app.route("/add", methods=["POST"])
def add():
    data = request.json
    return jsonify({"result": data["a"] + data["b"]})

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=PORT)