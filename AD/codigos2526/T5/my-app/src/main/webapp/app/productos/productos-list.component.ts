import { Component, inject, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavigationEnd, Router, RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ErrorHandler } from 'app/common/error-handler.injectable';
import { ProductosService } from 'app/productos/productos.service';
import { ProductosDTO } from 'app/productos/productos.model';


@Component({
  selector: 'app-productos-list',
  imports: [CommonModule, RouterLink],
  templateUrl: './productos-list.component.html'})
export class ProductosListComponent implements OnInit, OnDestroy {

  productosService = inject(ProductosService);
  errorHandler = inject(ErrorHandler);
  router = inject(Router);
  productoses?: ProductosDTO[];
  navigationSubscription?: Subscription;

  getMessage(key: string, details?: any) {
    const messages: Record<string, string> = {
      confirm: $localize`:@@delete.confirm:Do you really want to delete this element? This cannot be undone.`,
      deleted: $localize`:@@productos.delete.success:Productos was removed successfully.`    };
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
    this.productosService.getAllProductoses()
        .subscribe({
          next: (data) => this.productoses = data,
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

  confirmDelete(id: number) {
    if (!confirm(this.getMessage('confirm'))) {
      return;
    }
    this.productosService.deleteProductos(id)
        .subscribe({
          next: () => this.router.navigate(['/productoss'], {
            state: {
              msgInfo: this.getMessage('deleted')
            }
          }),
          error: (error) => this.errorHandler.handleServerError(error.error)
        });
  }

}
