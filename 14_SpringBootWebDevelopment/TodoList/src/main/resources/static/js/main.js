$(function(){

    const appendTask = function(data){
        var taskCode = '<a href="#" class="task-link" data-id="' +
            task.id + '">' + task.taskText + '</a><br>';
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

//    Loading books on load page
//    $.get('/tasks/', function(response)
//    {
//        for(i in response) {
//            appendBook(response[i]);
//        }
//    });

    //Show adding task form
    $('#show-add-task-form').click(function(){
        $('#task-form').css('display', 'flex');
    });

    //Closing adding task form
    $('#task-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting task
    $(document).on('click', '.task-link', function(){
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/tasks/' + taskId,
            success: function(response)
            {
                var code = '<br><span>' + response.description + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Задача не найдена!');
                }
            }
        });
        return false;
    });

    //Adding task
    $('#save-task').click(function()
    {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/tasks/',
            data: data,
            success: function(response)
            {
                $('#task-form').css('display', 'none');
                var task = {};
                task.id = response;
                var dataArray = $('#task-form form').serializeArray();
                for(i in dataArray) {
                    task[dataArray[i]['taskText']] = dataArray[i]['value'];
                }
                appendTask(task);
            }
        });
        return false;
    });

//  Deleting task
    $(document).on('click', '.delete', function(){
        var link = document.querySelector('#task-list > div > span.delete').getAttribute('data-delete-id');
        alert(link);
        $.ajax({
            method: "DELETE",
            url: '/tasks/' + taskId,
            success: function(response)
            {
                var code = '<br><div class="deleted"> data-id="' + task.id + '</div> <span>' + response.id + '. ' + response.description + '</span>';
                link.parent().append(code);
            }
       })
       return false;
    });
});
