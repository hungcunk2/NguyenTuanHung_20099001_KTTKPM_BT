FROM node:18
WORKDIR /app
COPY package.json ./
RUN npm install
RUN echo 'const express = require("express");\
          const app = express();\
          app.get("/", (req, res) => res.send("Hello, Docker!"));\
          app.listen(3000, () => console.log("Server running on port 3000"));' > index.js
RUN npm install express
EXPOSE 3000
CMD ["node", "index.js"]