using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace demo.interfaces
{
    public interface IBabyAccount: IAccount
    {
        public string GetParentName();
    }
}