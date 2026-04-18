import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { ProfesorService } from 'app/profesor/profesor.service';
import { ProfesorDTO } from 'app/profesor/profesor.model';


@Component({
  selector: 'app-profesor-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './profesor-list.component.html'})
export class ProfesorListComponent implements OnInit, OnDestroy {

  profesorService = inject(ProfesorService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  profesors?: ProfesorDTO[];
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@profesor.delete.success:Profesor was removed successfully.`    };
    return messages[key];
  }

  ngOnInit() {
    this.loadData();
    this.navigationSubscription = this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.loadData();
      }
    });
  }

  ngOnDestroy() {
    this.navigationSubscription!.unsubscribe();
  }
  
  loadData() {
    this.profesorService.getAllProfesors()
        .subscribe({
          next: (data) => this.profesors = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  confirmDelete(id: number) {
    if (!confirm(this.getMessage('confirm'))) {
      return;
    }
    this.profesorService.deleteProfesor(id)
        .subscribe({
          next: () => this.router.navigate(['/profesors'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

}
