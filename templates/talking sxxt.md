Introduction:

My name is Huici Pan, 26 years old. I spent 6 years for learning Computer Science in university. 4 years in northeastern University China and 2 years in New York University. After I graduated from New York University in mid of 2018 then I joined in Amazon Seller Payments Report Team. I have worked for this team more than 1 year. So what I am doing now is to make sure all of seller can generate their report well and try to do something to improve their experience. 

Most challenging project:

Like the current project I’m doing. So Amazon need to pay seller after each settlement/period. 
But that pay/disbursement might fail for a lot of reasons like sellers’ bank-account routing number is nor correct or the bank of some international sellers is not supported target currency. We get a lot of feedbacks that seller ask where is their money. So this project is to add a new page in Amazon Seller Central to provide status(stay) of their disbursement. 

The first problem we meet is that we don’t own those data. We are down-stream team so that we need to call API of up-stream team. But we don’t have want to add more dependency on our service since our latency is already high. we decided to move data and store them in our own side. As I just mentioned, we are down-stream team. So the first thing I need to do backfill data. I talk . Although this project has high level design doc, I wrote a lot low level design doc for each step. 

