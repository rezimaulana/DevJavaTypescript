import { NgModule } from '@angular/core';
import { Routes, RouterModule  } from '@angular/router';
import { ReactiveFormsAreaModule } from 'projects/reactive-forms-area/src/app/reactive-forms-area.module';
import { reactiveFormsAreaRoutes } from 'projects/reactive-forms-area/src/app/reactive-forms-area.routing';
import { TemplateDrivenFormsAreaModule } from 'projects/template-driven-forms-area/src/app/template-driven-forms-area.module';
import { templateDrivenFormsAreaRoutes } from 'projects/template-driven-forms-area/src/app/template-driven-forms-area.routing';
import { AppComponent } from './app.component';
import { Page404Component } from './pages/not-found/page404.component';

export const mainRoutes: Routes = [
    ...templateDrivenFormsAreaRoutes, ...reactiveFormsAreaRoutes,
    {
        path: '',
        component: AppComponent
    },
    {
        path: '**',
        component: Page404Component
    },
]

@NgModule({
    imports: [
        RouterModule.forRoot(mainRoutes),
        ReactiveFormsAreaModule, TemplateDrivenFormsAreaModule

    ],
    exports: [
        RouterModule, ReactiveFormsAreaModule, TemplateDrivenFormsAreaModule
    ]
})
export class AppRouting { }