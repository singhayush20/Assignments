<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="calculator.css">
</head>
<body>
    <div class="container">
        <h2>Calculator</h2>
        <form action="calculate" method="post">
            Enter First Number: <input type="number" name="num1" required><br>
            Enter Second Number: <input type="number" name="num2" required><br>
            Select Operation:
            <select name="Operator" required>
                <option value="+">Add</option>
                <option value="-">Subtract</option>
                <option value="*">Multiply</option>
                <option value="/">Divide</option>
            </select><br>
            <input type="submit" value="Calculate">
        </form>
    </div>
</body>
</html>
