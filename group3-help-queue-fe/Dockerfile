FROM node:14.16.1-alpine
WORKDIR /group3-help-queue-fe
ENV PATH /group3-help-queue-fe/node_modules/.bin:$PATH
COPY package.json ./
COPY package-lock.json ./
RUN npm install --silent
COPY . .
EXPOSE 3000
CMD ["npm","test", "--","--coverage","--watchAll"]
ENTRYPOINT ["npm", "start"]