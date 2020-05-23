import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { ResponseGeneral } from '../models/response-general.model';
import { Constantes } from '../utils/constantes';
import { Animal } from '../models/animal.model';


@Injectable({
  providedIn: 'root'
})
export class ModificarAnimalService {

  constructor(private http: HttpClient) { }

  setAnimales(programationRequest: Array<Animal>): Observable<ResponseGeneral> {
    console.log('setAnimales()');
    return this.http.post<ResponseGeneral>(Constantes.URL_SERVICE + '/excelAnimales/subir', programationRequest).pipe(
      tap(
        (response) => {
          console.log('ModificarAnimalService::');
          console.log(response);
        },
        (error) => {
          console.error('ModificarAnimalService::');
          console.error(error);
        }
      )
    );
  }
}
