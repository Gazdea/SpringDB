<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Medical Records</title>
</head>
<script>
    function editMode(id) {
        var patientid = document.getElementsByName('patientId-' + id)[0].value;
        var record_details = document.getElementsByName('recordDetails-' + id)[0].value;
        var updaterecord_id = document.getElementsByName('updaterecordId')[0];
        var updatepatient_id = document.getElementsByName('updatepatientId')[0];
        var updaterecord_details = document.getElementsByName('updaterecordDetails')[0];
        updaterecord_id.value = id;
        updatepatient_id.value = patientid;
        updaterecord_details.value = record_details;
    }
</script>
<body>
<a href="patients">back</a>
<h2>Medical Records</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Patient_ID</th>
        <th>Record Details</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="medicalrecords" items="${medicalrecords}">
        <tr>
            <td><input type="text" name="record_id-${medicalrecords.recordId}" value="${medicalrecords.recordId}" disabled></td>
            <td><input type="text" name="patient_id-${medicalrecords.recordId}" value="${medicalrecords.patientId}" disabled></td>
            <td><input type="text" name="record_details-${medicalrecords.recordId}" value="${medicalrecords.recordDetails}" disabled></td>
            <td>
                <input type="button" value="Select" onclick="editMode(${medicalrecords.recordId})">
                <form action="medicalrecords" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="recordId" value="${medicalrecords.recordId}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <tr>
        <th>patient id</th>
        <th>record details</th>
    </tr>
    <tr>
        <form action="medicalrecords" method="post">
            <input type="hidden" name="action" value="add">
            <td> <input type="text" id="addpatientId" name="patientId" required> </td>
            <td> <input type="text" id="addrecordDetails" name="recordDetails" required> </td>
            <td> <input type="submit" value="Add"> </td>
        </form>
    </tr>
</table>
<table>
    <tr>
        <th>record id</th>
        <th>patient id</th>
        <th>record details</th>
    </tr>
    <tr>
        <form action="medicalrecords" method="post">
            <input type="hidden" name="action" value="update">
            <td> <input type="text" name="updaterecordId" required></td>
            <td> <input type="text" name="updatepatientId" required> </td>
            <td> <input type="text" name="updaterecordDetails" required> </td>
            <td> <input type="submit" name="update" value="Update"> </td>
        </form>
    </tr>
</table>
</table>
<br>
</body>
</html>