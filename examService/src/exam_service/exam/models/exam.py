from django.db import models


class Exam(models.Model):
    name = models.CharField(max_length=128)
    description = models.TextField(max_length=512, null=True, blank=True)
    # avatar = models.FileField()
    is_active = models.BooleanField(default=False)