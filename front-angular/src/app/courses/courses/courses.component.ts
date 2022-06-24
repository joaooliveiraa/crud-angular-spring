import { ErrorDialogComponent } from './../../shared/components/error-dialog/error-dialog.component';
import { Course } from './model/course';
import { Component, OnInit } from '@angular/core';
import { CoursesService } from './services/courses.service';
import { catchError, Observable, of } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss'],
})
export class CoursesComponent implements OnInit {
  courses$: Observable<Course[]>;
  displayedColumns = ['name', 'category'];

  //Instanciando courseService
  constructor(private courseService: CoursesService, public dialog: MatDialog) {
    this.courses$ = this.courseService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar cursos.')
        return of([]); //Observable que irá retornar um array vazio
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  ngOnInit(): void {}
}