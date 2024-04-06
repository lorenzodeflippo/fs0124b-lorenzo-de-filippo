const handleSubmit = function (e) {
  e.preventDefault();
  addTask();
  attachComplete();
  attachDelete();
};

const addTask = function () {
  let tasks = document.querySelector("#tasks");
  let inputField = document.querySelector("#newTask input");
  let newTask = `
        <div class="task">
            <span id="taskname">
                ${inputField.value}
            </span>
        </div>
    `;
  tasks.innerHTML += newTask;
  inputField.value = "";
};

const attachComplete = function () {
  let allTasks = document.querySelectorAll(".task");
  for (let i = 0; i < allTasks.length; i++) {
    allTasks[i].addEventListener("click", function () {
      this.classList.toggle("completed");
    });
  }
};

window.onload = function () {
  let form = document.querySelector("form");
  form.addEventListener("submit", handleSubmit);
};
