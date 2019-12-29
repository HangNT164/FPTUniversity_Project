<%-- 
    Document   : demoUpImg
    Created on : Nov 7, 2019, 8:15:17 PM
    Author     : TuanNA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <form action="" method="post" enctype="multipart/form-data" acceptcharset="UTF-8">
            <p>id
            <input type="text" name="product">
             <p>name
            <input type="text" name="subcate_id">
             <p>color
            <input type="text" name="product_name">
             <p>quantity
            <input type="text" name="color">
             <p>sellP
            <input type="text" name="quantity">
               <p>origginP
            <input type="text" name="sell_price">
               <p>Descrip
            <input type="text" name="orgin_price">
               <p>PrroductCode
            <input type="text" name="description">
                <p>Create_date
            <input type="text" name="product_code">
                <p>deleted
            <input type="date" name="create_date">
                      <p>Chon anh
                          <input type ="file" name="fileUp" multiple>
            <button type="submit" name="submit">Add<button>
    </form>
            
    </body>
</html>
