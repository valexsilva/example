import { Component, OnInit } from '@angular/core';
import { Animal } from '../models/animal.model';
import * as XLSX from 'xlsx';
import { ModificarAnimalService } from '../services/modificar-animal.service';

@Component({
  selector: 'app-excel',
  templateUrl: './excel.component.html',
  styleUrls: ['./excel.component.css']
})
export class ExcelComponent implements OnInit {

  importAnimals = new Array<Animal>();
  p = 1;
  editField: string;
  mensajeRespuesta: string;

  constructor(private modificarAnimalServise: ModificarAnimalService) { }

  ngOnInit(): void {}

  onFileChange(evt: any) {
    const target: DataTransfer = (evt.target) as DataTransfer;
    if (target.files.length !== 1) { throw new Error('Cannot use multiple files'); }

    const reader: FileReader = new FileReader();
    reader.onload = (e: any) => {

      const bstr: string = e.target.result;
      const data = this.importFromFile(bstr) as any[];
      console.log(this.importAnimals);
      const header: string[] = Object.getOwnPropertyNames(new Animal());
      this.importAnimals = data;
      console.log(this.importAnimals);
    };
    reader.readAsBinaryString(target.files[0]);

  }

  importFromFile(bstr: string): XLSX.AOA2SheetOpts {
    /* read workbook */
    const wb: XLSX.WorkBook = XLSX.read(bstr, { type: 'binary' });

    /* grab first sheet */
    const wsname: string = wb.SheetNames[0];
    const ws: XLSX.WorkSheet = wb.Sheets[wsname];

    /* save data */
    const data = (XLSX.utils.sheet_to_json(ws, { header: 0 })) as XLSX.AOA2SheetOpts;

    return data;
  }

   // evento para paginador de la tabla
   onPageChange(event: any) {
    this.p = event;
  }

  guardar() {
    console.log(this.importAnimals);
    if (this.importAnimals.length > 0) {
    this.modificarAnimalServise.setAnimales(this.importAnimals)
      .subscribe(
        response => {
           console.log(response);
           this.mensajeRespuesta = response.message;
        },
        error => {
          this.mensajeRespuesta = 'Ocurrio un error al guardar animales.';
          console.error(error);
        });
      } else {
        this.mensajeRespuesta = 'No hay elementos.';
      }
  }
}
