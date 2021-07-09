$(function(){

    const appendTask = function(data){
        var taskCode = '<a href="#" class="task-link" data-id="' +
            task.id + '">' + task.taskText + '</a><br>';
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

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
    $(document).on('click', '.delete', function() {
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
             method: "DELETE",
             url: '/tasks/' + taskId,
             success: function(response)
             {
                  alert('Задача удалена! Обновите страницу');
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

    var change;
    var changeTaskId;
     //show changing task form
     $(document).on('click', '.edit', function(){
         change = $(this);
         changeTaskId =change.data('id') ;
            $('#changes-form').css('display', 'flex');
        });

     //close changing task form
     $('#changes-form').click(function(event){
             if(event.target === this) {
                 $(this).css('display', 'none');
             }
         });

     $('#save-changedTask').click(function()
        {
            var data = $('#changes-form form').serialize();
            $.ajax({
                method: "PUT",
                url: '/tasks/' + changeTaskId,
                data: data,
                success: function(response)
                {
                    $('#changes-form').css('display', 'none');
                    var task = {};
                    task.id = changeTaskId;
                    var dataArray = $('#changes-form form').serializeArray();
                    for(i in dataArray) {
                        task[dataArray[i]['taskText']] = dataArray[i]['value'];
                    }
                    appendTask(task);
                }
            });
            return false;
        });

});
