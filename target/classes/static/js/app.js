document.addEventListener('DOMContentLoaded', () => {
    const employeeForm = document.getElementById('employeeForm');
    const checkinForm = document.getElementById('checkinForm');
    const employeeReportForm = document.getElementById('employeeReportForm');
    const managerReportForm = document.getElementById('managerReportForm');

    employeeForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const nome = document.getElementById('employeeName').value;
        const apelido = document.getElementById('employeeNickname').value;
        const cargaHoraria = document.getElementById('employeeWorkload').value;
        const dataContratacao = document.getElementById('employeeHireDate').value;

        const response = await fetch('http://localhost:8080/employee', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nome, apelido, cargaHoraria, dataContratacao })
        });

        if (response.ok) {
            alert('Employee added successfully');
            employeeForm.reset();
        } else {
            alert('Error adding employee');
        }
    });

    checkinForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const employeeId = document.getElementById('employeeId').value;

        const response = await fetch('http://localhost:8080/attendance/checkin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ employeeId })
        });

        if (response.ok) {
            alert('Check-in/Checkout successful');
            checkinForm.reset();
        } else {
            alert('Error during check-in/checkout');
        }
    });

    employeeReportForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const employeeId = document.getElementById('reportEmployeeId').value;
        const startDate = document.getElementById('reportStartDate').value;
        const endDate = document.getElementById('reportEndDate').value;

        const response = await fetch(`http://localhost:8080/attendance/employee-report?employeeId=${employeeId}&startDate=${startDate}&endDate=${endDate}`);

        if (response.ok) {
            const report = await response.json();
            displayReport(report);
        } else {
            alert('Error fetching employee report');
        }
    });

    managerReportForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const startDate = document.getElementById('managerReportStartDate').value;
        const endDate = document.getElementById('managerReportEndDate').value;

        const response = await fetch(`http://localhost:8080/attendance/manager-report?startDate=${startDate}&endDate=${endDate}`);

        if (response.ok) {
            const report = await response.json();
            displayReport(report);
        } else {
            alert('Error fetching manager report');
        }
    });

    function displayReport(report) {
        const reportResults = document.getElementById('reportResults');
        reportResults.innerHTML = `<pre>${JSON.stringify(report, null, 2)}</pre>`;
    }
});