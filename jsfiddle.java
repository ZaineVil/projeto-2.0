function addTask() {
  const taskInput = document.getElementById('taskInput');
  const taskList = document.getElementById('taskList');
  const taskText = taskInput.value.trim();

  if (taskText === '') {
    alert('Please enter a task');
    return;
  }

  // Create a new task item
  const taskItem = document.createElement('li');
  taskItem.className = 'task-item';
  taskItem.innerHTML = `
    <span>${taskText}</span>
    <div>
      <button onclick="editTask(this)">Edit</button>
      <button onclick="removeTask(this)">Delete</button>
    </div>
  `;

  // Add the new task item to the task list
  taskList.appendChild(taskItem);

  // Clear the input field
  taskInput.value = '';
}

function removeTask(button) {
  const taskList = document.getElementById('taskList');
  taskList.removeChild(button.parentElement.parentElement);
}

function editTask(button) {
  const taskItem = button.parentElement.parentElement;
  const taskText = taskItem.querySelector('span').textContent;
  const newTaskText = prompt('Edit task:', taskText);

  if (newTaskText !== null && newTaskText.trim() !== '') {
    taskItem.querySelector('span').textContent = newTaskText.trim();
  }
}
