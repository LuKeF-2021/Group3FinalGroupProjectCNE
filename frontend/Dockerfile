FROM node:13.12.0-alpine
WORKDIR /group3-help-queue-fe
ENV PATH /group3-help-queue-fe/node_modules/.bin:$PATH
RUN npm install --silent
COPY ..
ENTRYPOINT ["npm", "start"]