# Write your MySQL query statement below
select Prices.product_id,round(coalesce(sum(Prices.price*UnitsSold.units)/sum(UnitsSold.units),0),2) as average_price from Prices
Left join  UnitsSold on UnitsSold.product_id=Prices.product_id
And UnitsSold.purchase_date Between Prices.start_date And Prices.end_date
Group by Prices.product_id;
