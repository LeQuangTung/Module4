function getAllEmployee() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employees",
        success: function (a) {
            let content = '<tr>\n' +
                '           <td>Code</td>\n' +
                '           <td>Name</td>\n' +
                '           <td>Age</td>\n' +
                '           <td>Salary</td>\n' +
                '           <td>Branch</td>\n' +
                '        <td colspan="3" style="padding-left:  50px">Action</td>\n' +
                '           </tr>';
            for (let i = 0; i < a.length; i++) {
                content += displayEmployee(a[i]);
            }
            document.getElementById('list_employee').innerHTML = content;
        }
    });
}


function displayEmployee(employee) {
    return `<tr><td>${employee.code}</td>
                <td onclick="getIdEmployee(${employee.id}); location.href = 'detail.html'">${employee.name}</td>
                <td>${employee.age}</td>
                <td>${employee.salary}</td>
               <td>${employee.branch.name}</td>
        <td><button class="btn btn-danger" onclick="deleteEmployee(${employee.id})">Delete</button>
        <button class="btn btn-warning" onclick="getIdEmployee(${employee.id}); location.href = 'update.html'">Update</button></td></tr>`;
}


function findAllbranch(employee) {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/branchs",
        success: function (data) {
            let content = `<select id="branch">`
            if (employee != null) {
                content += `<option value="${employee.branch.id}">${employee.branch.name}</option>`
                for (let i = 0; i < data.length; i++) {
                    if (employee.branch.id !== data[i].id) {
                        content += displayBranch(data[i])
                    }
                }
                content += `<select>`
                document.getElementById("branchUpdate").innerHTML = content;
            } else {
                for (let i = 0; i < data.length; i++) {
                    content += displayBranch(data[i])
                }
                content += `<select>`
                document.getElementById("branchForm").innerHTML = content;
            }
        }
    });
}

function displayBranch(branch) {
    return `<option value="${branch.id}">${branch.name}</option>`
}

function displayCreateForm() {
    findAllbranch()
}

function createEmployee() {
    let code = $("#employeeCode").val()
    let name = $("#name").val()
    let age = $("#age").val()
    let salary = $("#salary").val()
    let branch = $("#branch").val()
    let newEmployee = {
        code: code,
        name: name,
        age: age,
        salary: salary,
        branch: {
            id: branch
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        url: "http://localhost:8080/employees",
        data: JSON.stringify(newEmployee),
        success: function (data) {
            getAllEmployee()
            if (data.name != null) {
                alert("Create Successfully!")
                window.location.href = 'employee.html'
            }
        }
    })
    event.preventDefault();
}

function deleteEmployee(id) {
    if (confirm("Are you sure to delete?")) {
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8080/employees/" + id,
            success: function (data) {
                getAllEmployee()
                alert("Delete Successfully!")
            }
        });
    }
}


function getIdEmployee(id) {
    $.ajax({
        type: "GET",
        url:  "http://localhost:8080/employees/" + id,
        success : function () {
            sessionStorage.setItem("IdUpdate", id)
        }
    })
}




function updateEmployee() {
    let idUpdate = sessionStorage.getItem("IdUpdate")
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/employees/" + idUpdate,
        success: function (data) {
            $("#employeeCodeUpdate").val(data.code)
            $("#nameUpdate").val(data.name)
            $("#ageUpdate").val(data.age)
            $("#salaryUpdate").val(data.salary)
            $("#branchUpdate").val(data.branch.name)
            findAllbranch(data)
        }
    });
}

function update() {
    let idUpdate1 = sessionStorage.getItem("IdUpdate")
    let code = $("#employeeCodeUpdate").val()
    let name = $("#nameUpdate").val()
    let age = $("#ageUpdate").val()
    let salary = $("#salaryUpdate").val()
    let branchId = $("#branch").val()
    let newEmployee = {
        id: idUpdate1,
        code : code,
        name: name,
        age: age,
        salary: salary,
        branch: {
            id : branchId
        }
    }
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        url: "http://localhost:8080/employees/" + idUpdate1,
        data: JSON.stringify(newEmployee),
        success: function (data) {
            if (data.name != null) {
                alert("Thay đổi thành công!")
                location.href = "employee.html"
            }
        }
    });
    event.preventDefault();
}



function back() {
    window.location.href = " employee.html"
    event.preventDefault()
}


function sortByAge() {
    $.ajax({
        type: "GET",
        url:  "http://localhost:8080/employees/sort",
        success : function (data) {
            let content = '<tr>\n' +
                '           <td>Code</td>\n' +
                '           <td>Name</td>\n' +
                '           <td>Age</td>\n' +
                '           <td>Salary</td>\n' +
                '           <td>branch</td>\n' +
                '        <td colspan="3" style="padding-left:  50px">Action</td>\n' +
                '           </tr>';
            for (let i = 0; i < data.length; i++) {
                content += displayEmployee(data[i]);
            }
            document.getElementById('list_sort').innerHTML = content;
            document.getElementById("list_employee").innerHTML = "";
        }
    });
}
