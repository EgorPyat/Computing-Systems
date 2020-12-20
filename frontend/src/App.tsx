import React, {useEffect, useState} from 'react';
import './App.css';
import {Api} from "./api/Api";
import {CsEntityDto, CsEntityHierarchyDto} from "./api/computing-systems";

function App() {
    const [data, setData] = useState<CsEntityHierarchyDto>();
    const [content, setContent] = useState<CsEntityDto>();

    useEffect(() => {
        Api.getCsEntityHierarchy().then(response => setData(response.data));
    }, [])

    const handleEntityClick = (entity: CsEntityDto | undefined) => {
        console.log(entity)
        setContent(entity);
    };

    const handleInput = (e) => {

    };

    const renderHierarchy = (rootEntities: (CsEntityDto | undefined)[] | undefined) => {
        return (
            <ul key={Date.now()}>
                {rootEntities?.map(entity => (
                    <>
                        <li className="list-item" key={entity?.id}
                            onClick={() => handleEntityClick(entity)}>{entity?.name}</li>
                        {renderHierarchy(entity?.descendants.map(d => data?.entities[d]))}
                    </>
                ))}
            </ul>
        );
  };

  return (
    <div className="wrapper">
      <div className="header">Классификация вычислительных систем</div>
      <div className="article">
        <div>
            <h4>{content?.name}</h4>
            <p>{content?.description}</p>
            <br/>
            {content && content?.descendants && content?.descendants.length > 0 &&
            <div>
                <h5>Связанные термины:</h5>
                <ul>
                    {content.descendants.map(d => <li className="list-item"
                                                      onClick={() => handleEntityClick(data?.entities[d])}
                                                      key={data?.entities[d].id}>{data?.entities[d].name}</li>)}
                </ul>
            </div>}
            {content && content?.parents && content.parents.length > 0 &&
            <div>
                <h5>Головные термины:</h5>
                <ul>
                    {content?.parents.map(d => <li className="list-item"
                                                   onClick={() => handleEntityClick(data?.entities[d])}
                                                   key={data?.entities[d].id}>{data?.entities[d].name}</li>)}
                </ul>
            </div>}
        </div>
      </div>
      <div className="aside">
        <div className="search">
          Поиск:
          <input type="text" name="name" onChange={handleInput}/>
        </div>
          {renderHierarchy(data?.rootEntities.map(e => data?.entities[e]))}
      </div>
      <div className="footer">Пятаев Егор Евгеньевич, 19223. Вычислительные системы, 2020</div>
    </div>
  );
}

export default App;
