<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patients</title>
</head>
<script>
    function editMode(id) {
        var name = document.getElementsByName('name-' + id)[0].value;
        var birth_date = document.getElementsByName('birthDate-' + id)[0].value;
        var updatepatientId = document.getElementsByName('updatepatientId')[0];
        var updatename = document.getElementsByName('updatename')[0];
        var updatebirth_date = document.getElementsByName('updatebirth_date')[0];
        updatepatientId.value = id;
        updatename.value = name;
        updatebirth_date.value = birth_date;
    }
</script>
<body>
<a href="index.jsp">Back</a>
<h2>Patients</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Birth date</th>
        <th>Record details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="patients" items="${patients}">
        <tr>
            <td><input type="text" name="patientId-${patients.patientId}" value="${patients.patientId}" disabled></td>
            <td><input type="text" name="name-${patients.patientId}" value="${patients.name}" disabled></td>
            <td><input type="date" name="birth_date-${patients.patientId}" value="${patients.birthDate}" disabled></td>
            <td><input type="text" name="record_details-${patients.medicalRecord.recordId}" value="${patients.medicalRecord.recordDetails}"></td>
            <td>
                <input type="button" value="Select" onclick="editMode(${patients.patientId})">
                <form action="patients" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="patientId" value="${patients.patientId}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <tr>
        <th>name</th>
        <th>birth date</th>
    </tr>
    <tr>
        <form action="patients" method="post">
            <input type="hidden" name="action" value="add">
            <td><input type="text" name="addname" required></td>
            <td><input type="date" name="addbirthDate" required></td>
            <td><input type="submit" value="Add"></td>
        </form>
    </tr>
</table>
<table>
    <tr>
        <th>patient id</th>
        <th>name</th>
        <th>birth date</th>
    </tr>
    <tr>
        <form action="patients" method="post">
            <input type="hidden" name="action" value="update">
            <td><input type="text" name="updatepatientId" required></td>
            <td><input type="text" name="updatename" required></td>
            <td><input type="date" name="updatebirthDate" required></td>
            <td><input type="submit" value="Update"></td>
        </form>
    </tr>
</table>
<a href="medicalrecords">Add record details</a>
</body>
</html>