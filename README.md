<!DOCTYPE html>
<html>
<head>
    <title>CSS Assignment</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f9;
            margin: 40px;
        }

        h2 {
            text-align: center;
        }

        /* ===== FORM STYLING ===== */

        form {
            width: 400px;
            margin: auto;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        input:focus, select:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* ===== TABLE STYLING ===== */

        table {
            width: 80%;
            margin: 40px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

    </style>

</head>

<body>

    <h2>Student Registration Form</h2>

    <form>
        <label>Name:</label>
        <input type="text" placeholder="Enter your name">

        <label>Email:</label>
        <input type="email" placeholder="Enter your email">

        <label>Course:</label>
        <select>
            <option>B.Tech</option>
            <option>BCA</option>
            <option>B.Sc</option>
        </select>

        <button type="submit">Submit</button>
    </form>

    <h2>Student Details Table</h2>

    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
        </tr>

        <tr>
            <td>Rahul</td>
            <td>rahul@gmail.com</td>
            <td>B.Tech</td>
        </tr>

        <tr>
            <td>Anjali</td>
            <td>anjali@gmail.com</td>
            <td>BCA</td>
        </tr>

        <tr>
            <td>Vikram</td>
            <td>vikram@gmail.com</td>
            <td>B.Sc</td>
        </tr>
    </table>

</body>
</html>
