import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { EmpleadosService } from 'app/empleados/empleados.service';
import { EmpleadosDTO } from 'app/empleados/empleados.model';


@Component({
  selector: 'app-empleados-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './empleados-list.component.html'})
export class EmpleadosListComponent implements OnInit, OnDestroy {

  empleadosService = inject(EmpleadosService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  empleadoses?: EmpleadosDTO[];
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@empleados.delete.success:Empleados was removed successfully.`    };
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
    this.empleadosService.getAllEmpleadoses()
        .subscribe({
          next: (data) => this.empleadoses = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  confirmDelete(id: number) {
    if (!confirm(this.getMessage('confirm'))) {
      return;
    }
    this.empleadosService.deleteEmpleados(id)
        .subscribe({
          next: () => this.router.navigate(['/empleadoss'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

}
