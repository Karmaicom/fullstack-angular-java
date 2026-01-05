import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
  // instanciar a biblioteca HttpClient
  private http = inject(HttpClient);

  ngOnInit() {
    // executando uma requisicao Http do tipo Get para a API
    this.http.get('http://localhost:8081/api/v1/clientes')
      .subscribe(
        (data) => { // aguardando a resposta da API
           console.log(data); // exibindo os dados retornados no console
        }
      );
  }

}