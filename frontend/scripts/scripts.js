const setFormsAdd = {
        addMedicamento:{ 
            animal:{
                For: "animal",
                Text: "Tipo de animal",
                Type:"text",
                Id: "animal",
                Name: "animal",
                Placeholder: "Digite o tipo de animal",
            },
            nome:{
                For: "medicamento",
                Text: "Nome do medicamento",
                Type:"text",
                Id: "medicamento",
                Name: "medicamento",
                Placeholder: "Digite o nome do medicamento",
            },
            quantidade:{
                For: "qtd",
                Text: "Quantidade de medicamento",
                Type:"number",
                Id: "qtd",
                Name: "qtd",
                Placeholder: "Digite a quantidade de medicamento",
            }
        },
        addAnimal:{
            id:{
                For: "id",
                Text: "id do animal",
                Type:"number",
                Id: "id",
                Name: "id",
                Placeholder: "Digite o id do animal",
            },
            nome:{
                For: "nome",
                Text: "Nome do animal",
                Type:"text",
                Id: "nome",
                Name: "nome",
                Placeholder: "Digite o nome do animal",
            },
            idade:{
                For: "idade",
                Text: "Idade do animal",
                Type:"number",
                Id: "idade",
                Name: "idade",
                Placeholder: "Digite a idade do animal",
            },
            raca:{
                For: "raca",
                Text: "Raça do animal",
                Type:"text",
                Id: "raca",
                Name: "raca",
                Placeholder: "Digite a raça do animal",
            },
            tipo:{
                For: "tipo",
                Text: "Tipo do animal",
                Type:"text",
                Id: "tipo",
                Name: "tipo",
                Placeholder: "Digite o tipo do animal",
            },
        },
        addVeterinario:{ 
            id:{
                For: "id",
                Text: "id do veterinário",
                Type:"number",
                Id: "id",
                Name: "id",
                Placeholder: "Digite o id do veterinário",
            },
            nome:{
                For: "nome",
                Text: "Nome do veterinário",
                Type:"text",
                Id: "nome",
                Name: "nome",
                Placeholder: "Digite o nome do veterinário",
            },
            especialidade:{
                For: "especialidade",
                Text: "Especialidade",
                Type:"text",
                Id: "especialidade",
                Name: "especialidade",
                Placeholder: "Digite a especialidade do veterinário",
            },
        },
        addAgendamento:{
            id:{
                For: "id",
                Text: "id do agendamento",
                Type:"number",
                Id: "id",
                Name: "id",
                Placeholder: "Digite o id do agendamento",
            },
            data:{
                For: "data",
                Text: "Data do agendamento",
                Type:"date",
                Id: "data",
                Name: "data",
                Placeholder: ""
            },
            animal:{
                For: "animal",
                Text: "id do animal",
                Type:"number",
                Id: "animal",
                Name: "animal",
                Placeholder: "Digite o id do animal",
            },
            veterinario:{
                For: "veterinario",
                Text: "id do veterinário",
                Type:"number",
                Id: "veterinario",
                Name: "veterinario",
                Placeholder: "Digite o id do veterinário",
            }
        }
    };

putForm = {
    putVeterinario: {
        id:{
            For: "id",
            Text: "id do veterinário",
            Type:"number",
            Id: "id",
            Name: "id",
            Placeholder: "Digite o id do veterinário",
        },
        nome:{
            For: "nome",
            Text: "Nome do veterinário",
            Type:"text",
            Id: "nome",
            Name: "nome",
            Placeholder: "Digite o nome do veterinário",
        },
        especialidade:{
            For: "especialidade",
            Text: "Especialidade",
            Type:"text",
            Id: "especialidade",
            Name: "especialidade",
            Placeholder: "Digite a especialidade do veterinário",
        },
    },
    putMedicamento:{
        tipo:{
            For: "tipo",
            Text: "Tipo de animal",
            Type:"text",
            Id: "tipo",
            Name: "tipo",
            Placeholder: "Digite o tipo de animal",
        },
        nome:{
            For: "nome",
            Text: "Nome do medicamento",
            Type:"text",
            Id: "nome",
            Name: "nome",
            Placeholder: "Digite o nome do medicamento",
        
        },
        novoNome:{
            For: "novoNome",
            Text: "Novo nome do medicamento",
            Type:"text",
            Id: "novoNome",
            Name: "novoNome",
            Placeholder: "Digite o novo nome do medicamento",
        },
        agendamento:{
            id:{
                For: "id",
                Text: "id do agendamento",
                Type:"number",
                Id: "id",
                Name: "id",
                Placeholder: "Digite o id do agendamento",
            },
            data:{
                For: "data",
                Text: "Data do agendamento",
                Type:"date",
                Id: "data",
                Name: "data",
            },
            animal:{
                For: "animal",
                Text: "id do animal",
                Type:"number",
                Id: "animal",
                Name: "animal",
                Placeholder: "Digite o id do animal",
            },
            veterinario:{
                For: "veterinario",
                Text: "id do veterinário",
                Type:"number",
                Id: "veterinario",
                Name: "veterinario",
                Placeholder: "Digite o id do veterinário",
            }
        }
    }
}



document.querySelectorAll('.containerButtons').forEach(div => {
    div.addEventListener('click', function(event) {
        if (event.target.tagName === 'BUTTON') {
            console.log('Botão pressionado:', event.target.id);
            // Aqui você pode executar a ação desejada
            formulario = document.getElementById("form");
            formulario.innerHTML = ""; // Limpa o container antes de adicionar novo formulário

            switch(event.target.id) {
                case "add Medicamento":
                    
                    for (const key in setFormsAdd.addMedicamento) {
                        const element = setFormsAdd.addMedicamento[key];
                        createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder,
                            'Medicamento'
                        );
                        
                    }
                    createInput(
                        "novoNome",
                        "Novo nome",
                        "text",
                        "novoNome",
                        "novoNome",
                        "Digite o novo nome do medicamento",
                        'Medicamento'
                    )
                    createButton(formulario, "post", "Medicamento");
                    createButton(formulario, "get", "Medicamento");
                    createButton(formulario, "post", "aplMedicamento");
                    createButton(formulario, "put", "Medicamento");
                    break;
                case "add Animal":
                    for (const key in setFormsAdd.addAnimal) {
                        const element = setFormsAdd.addAnimal[key];
                        createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder,
                            'Animal'
                        );
                        
                    }
                    createButton(formulario, "post", "Animal");
                    createButton(formulario, "get", "Animal");
                    createButton(formulario, "delete", "Animal");
                    createButton(formulario, "put", "Animal");
                    break;
                case "add Veterinario":
                    for (const key in setFormsAdd.addVeterinario) {
                        const element = setFormsAdd.addVeterinario[key];
                        createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder,
                            'Veterinario'
                        );
                    }
                    createButton(formulario, "post", "Veterinario");
                    createButton(formulario, "get", "Veterinario");
                    createButton(formulario, "delete", "Veterinario");
                    createButton(formulario, "put", "Veterinario");
                    break;
                case "add Agendamento":
                    for (const key in setFormsAdd.addAgendamento) {
                        const element = setFormsAdd.addAgendamento[key];
                        createInput(
                            element.For,
                            element.Text,
                            element.Type,
                            element.Id,
                            element.Name,
                            element.Placeholder,
                            'Agendamento'
                        );
                    }
                    createButton(formulario, "post", "Agendamento");
                    createButton(formulario, "get", "Agendamento");
                    createButton(formulario, "delete", "Agendamento");
                    createButton(formulario, "put", "Agendamento");
                    break;
            }
            formulario.onsubmit = function(e){
                e.preventDefault();
                buttonId = e.submitter.id;
                console.log("submit", buttonId);
                operacaoo = buttonId.split(" ")[0];
                tipo = buttonId.split(" ")[1];
                switch(operacaoo) {
                    case "post":
                        postOperation(buttonId.split(" ")[1], Object.fromEntries(new FormData(formulario)));
                        break;
                    case "get":
                        getOperation(buttonId.split(" ")[1], Object.fromEntries(new FormData(formulario)));
                        break;
                    case "delete":
                        deleteOperation(buttonId.split(" ")[1], Object.fromEntries(new FormData(formulario)));
                        break;
                    case "put":
                        putOperation(buttonId.split(" ")[1], Object.fromEntries(new FormData(formulario)));
                        break;
                }

                
            }


            
        }
    });
});



postOperation = (tipo, dados) => {

    switch(tipo) {
        case "Medicamento":
            console.log("Postando medicamento:", dados);
            url = `http://localhost:8080/estoque/${dados.animal.toUpperCase()}/adicionar?nome=${dados.medicamento}&quantidade=${parseInt(dados.qtd)}`;
            fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("Medicamento adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar medicamento:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Animal":
            console.log("Postando animal:", dados);
            fetch(`http://localhost:8080/animais/${dados.tipo.toUpperCase()}`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    nome: dados.nome,
                    idade: parseInt(dados.idade),
                    raca: dados.raca
                })
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("animal adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar animal:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Veterinario":
            console.log("Postando veterinario:", dados);
            fetch(`http://localhost:8080/veterinarios`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(dados)
                
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("veterinario adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar veterinario:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "Agendamento":
            console.log("Postando agendamento:", dados);
            fetch('http://localhost:8080/agendamentos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    data: dados.data,
                    animal: parseInt(dados.animal),
                    veterinario: parseInt(dados.veterinario)
                })
                
            })
            .then(Response => {
                if (Response.ok) {
                    console.log("agendamento adicionado com sucesso!");
                } else {
                    console.error("Erro ao adicionar agendamento:", Response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro na requisição:", error);
            })
            break;
        case "aplMedicamento":
            console.log("Postando aplicação de medicamento:", dados);
            fetch(`http://localhost:8080/estoque/${dados.animal.toUpperCase()}/aplicar?nome=${dados.medicamento}&quantidade=${parseInt(dados.qtd)}`, {
                method: 'POST',
                
            })
    }
}


createInput = (lFor, lText, iType, iId, iName, iPlaceholder, tipo) => {
    form = document.getElementById("form");
    let label = document.createElement("label");
    label.setAttribute("for", lFor);
    label.innerText = lText;
    let input = document.createElement("input");
    input.setAttribute("type", iType);
    input.setAttribute("id", iId);
    input.setAttribute("name", iName);
    input.setAttribute("placeholder", iPlaceholder);

    form.appendChild(label);
    form.appendChild(input);
    
}

createButton = ( form, operacao, tipo) =>{
    button = document.createElement("button");
    button.setAttribute("id", `${operacao} ${tipo}`);
    button.setAttribute("type", "submit");
    
        switch(operacao){
            case "post":
                if(tipo === "aplMedicamento"){
                    button.setAttribute("value", operacao + " Medicamento");
                    button.innerText = `Aplicar`;
                }
                else {
                    button.setAttribute("value",operacao + " " + tipo);
                    button.innerText = `submit`;
                }
                
                break;
            case "get":
                button.setAttribute("value",operacao + " " + tipo);
                button.innerText = `buscar`;
                break;
            case "delete":
                button.setAttribute("value",operacao + " " + tipo);
                button.innerText = `deletar`;
                break;
            case "put":
                button.setAttribute("value",operacao + " " + tipo);
                button.innerText = `alterar`;
                break;
            
    }
    form.appendChild(button);
}

getOperation =(tipo, dados) =>{
    console.log("getOperation", tipo, dados);
    switch(tipo){
        case "Veterinario":
            if(!dados.id  || dados.id === ""){
                fetch('http://localhost:8080/veterinarios',{
                    method: 'GET',
                    
                })
                .then(response => response.json())
                .then(data =>{
                    console.log("Veterinarios:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar veterinarios:", error);
                })
            }
            else{
                fetch(`http://localhost:8080/veterinarios/${dados.id}`, {
                    method: 'GET'
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Veterinario:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar veterinario:", error);
                })
            }
            break;
        case "Medicamento":
            if ((!dados.animal || dados.animal === "") && (!dados.medicamento || dados.medicamento === "")) {
                fetch('http://localhost:8080/estoque/todos', {
                    method: 'GET',
                    
                   
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Medicamentos:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar medicamentos:", error);
                })
            }
            else if( (dados.medicamento && dados.medicamento.trim() !== "") && (!dados.animal && dados.animal.trim() === "")){
                fetch(`http://localhost:8080/estoque/buscar?nome=` + dados.medicamento,{
                    method: 'GET',
                    
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Medicamento:", data);
                })
                .catch(error => {
                    console.error("Erro ao buscar medicamento:", error);
                })
            }
            else if((dados.animal && dados.animal.trim() !== "") && (!dados.nome || dados.nome.trim() === "")){
                fetch(`http://localhost:8080/estoque/${dados.animal.toUpperCase()}`,{
                    method: 'GET',
                    
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Medicamentos do animal:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar medicamentos do animal:", error);
                })
            }
            break;
        case "Animal":
            if(!dados.id && dados.nome === '' && !dados.idade && dados.raca === '' && dados.tipo === ''){
                fetch('http://localhost:8080/animais', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data =>{
                    console.log("Animais:", data);
                    // Aqui você pode manipular os dados recebidos

                })
                .catch(error => {
                    console.error("Erro ao buscar animais:", error);
                })
            }
            else if(dados.id){
                fetch('http://localhost:8080/animais/' + dados.id, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Animal:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar animal:", error);
                })
            }
            else if(dados.nome){
                fetch(`http://localhost:8080/animais/search/${dados.nome}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Animal:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar animal:", error);
                })
            }
            else if(dados.tipo){
                fetch(`http://localhost:8080/animais/tipo/${dados.tipo.toUpperCase()}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Animais filtrados:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar animais filtrados:", error);
                })
            }
            break;
        case "Agendamento":
            if(!dados.id){
                fetch('http://localhost:8080/agendamentos', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Agendamentos:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar agendamentos:", error);
                })
            
            }
            else{
                fetch(`http://localhost:8080/agendamentos/${dados.id}`, {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        'Connection': 'keep-alive',
                        'keep-alive': 'timeout=60',
                        'transfer-encoding': 'chunked',
                    },
                })
                .then(response => response.json())
                .then(data => {
                    console.log("Agendamento:", data);
                    // Aqui você pode manipular os dados recebidos
                })
                .catch(error => {
                    console.error("Erro ao buscar agendamento:", error);
                })
            }

    }
}

deleteOperation = (tipo, dados) => {
    switch(tipo){
        case 'Veterinario':
            fetch(`http://localhost:8080/veterinarios/`+ dados.id, {
                method: 'DELETE',
                
            })
            .then(response => {
                if (response.ok) {
                    console.log("Veterinario deletado com sucesso!");
                } else {
                    console.error("Erro ao deletar veterinario:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao deletar veterinario:", error);
            })
            break;
        case 'Animal':
            fetch('http://localhost:8080/animais/' + dados.id, {
                method: 'DELETE',
            })
            .then(response => {
                if (response.ok) {
                    console.log("Animal deletado com sucesso!");
                } else {
                    console.error("Erro ao deletar Animal:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao deletar veterinario:", error);
            })
            break;
        case 'Agendamento':
            fetch(`http://localhost:8080/agendamentos/${dados.id}`, {
                method: 'DELETE',
            })
            .then(response => {
                if (response.ok) {
                    console.log("Agendamento deletado com sucesso!");
                } else {
                    console.error("Erro ao deletar agendamento:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao deletar agendamento:", error);
            })
            break;
    }
}

putOperation = (tipo, dados) => {
    switch(tipo){
        case "Veterinario":
            fetch(`http://localhost:8080/veterinarios/${dados.id}`, {
                method: 'PUT',
                headers:{
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    nome: dados.nome,
                    especialidade: dados.especialidade
                })
            })
            .then(response => {
                if (response.ok) {
                    console.log("Veterinario atualizado com sucesso!");
                } else {
                    console.error("Erro ao atualizar veterinario:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao atualizar veterinario:", error);
            })
            break;
        case "Medicamento":
            fetch('http://localhost:8080/estoque/' + dados.animal.toUpperCase() + '/editar-nome?antigo=' + dados.medicamento + '&novo=' + dados.novoNome, {
                method: 'PUT',  
            })
            .then(response => {
                if (response.ok) {
                    console.log("Medicamento atualizado com sucesso!");
                } else {
                    console.error("Erro ao atualizar medicamento:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao atualizar medicamento:", error);
            })
            break;
        case "Animal":
            fetch(`http://localhost:8080/animais/${dados.tipo.toUpperCase()}/${dados.id}`, {
                method: 'PUT',
                headers:{
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    nome: dados.nome,
                    idade: dados.idade,
                    raca: dados.raca
                })
                
            })
            .then(response => {
                if (response.ok) {
                    console.log("Animal atualizado com sucesso!");
                } else {
                    console.error("Erro ao atualizar animal:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao atualizar animal:", error);
            })
            break;
        case "Agendamento":
            fetch('http://localhost:8080/agendamentos/' + dados.id, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    data: dados.data,
                    animal: parseInt(dados.animal),
                    veterinario: parseInt(dados.veterinario)
                })
            })
            .then(response =>{
                if (response.ok) {
                    console.log("Agendamento atualizado com sucesso!");
                } else {
                    console.error("Erro ao atualizar agendamento:", response.statusText);
                }
            })
            .catch(error => {
                console.error("Erro ao atualizar agendamento:", error);
            })
            break;
    }   
}

